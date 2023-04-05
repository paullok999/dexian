package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.UserBrowseHistory;
import com.kalok.dexian.portal.mapper.UserBrowseHistoryMapper;
import com.kalok.dexian.portal.service.UserBrowseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserBrowseHistoryServiceImpl implements UserBrowseHistoryService {
    @Autowired
    private UserBrowseHistoryMapper userBrowseHistoryMapper;

    /**
     * 获取所有历史记录，并将历史记录构成一个Map(key:日期，value:对应日期的历史记录集合)
     * TODO:引入Redis来缓存历史记录,降低数据库查询频率
     * @return
     */
    @Override
    public Map<String, List<UserBrowseHistory>> getAllBrowseHistory() {
        Map<String, List<UserBrowseHistory>> map = new HashMap<String, List<UserBrowseHistory>>();
        //将所有浏览记录获取到(日期按降序,方便处理)
        List<UserBrowseHistory> userBrowseHistories = userBrowseHistoryMapper.getBrowseHistoryOrderByDate();
        //使用SimpleDateFormat转换date的格式,作为key
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String timeKey = "";
        for(UserBrowseHistory userBrowseHistory : userBrowseHistories){
            timeKey = dateFormat.format(userBrowseHistory.getBrowseTime());
            if(!map.containsKey(timeKey)){
                //如果没有,则新插入一条记录
                List<UserBrowseHistory> currUserBrowseHistories = new ArrayList<>();
                currUserBrowseHistories.add(userBrowseHistory);
                map.put(timeKey,currUserBrowseHistories);
            }else{
                //有,就将value自增
                map.get(timeKey).add(userBrowseHistory);
            }
        }
        return map;
    }

    @Override
    public void insertUserBrowseHistory(Long relationId, Integer historyType) {
        UserBrowseHistory userBrowseHistory = new UserBrowseHistory();
        userBrowseHistory.setBrowseTime(new Date());
        userBrowseHistory.setHistoryType(historyType);
        userBrowseHistory.setRelationId(relationId);
        /**
         * 假如之前已浏览过,则修改浏览时间
         */
        if(userBrowseHistoryMapper.queryByRelationId(relationId) > 0){
            userBrowseHistoryMapper.updateUserBrowseHistory(userBrowseHistory);
        }else{
            userBrowseHistoryMapper.insertUserBrowseHistory(userBrowseHistory);
        }
    }

    @Override
    public int deleteBrowseHistory() {
        return userBrowseHistoryMapper.deleteAllBrowseHistory();
    }


}
