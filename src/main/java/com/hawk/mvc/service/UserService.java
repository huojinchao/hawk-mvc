package com.hawk.mvc.service;

import com.hawk.mvc.beans.User;

import java.util.Date;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-05 06:31
 * <p>
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
public interface UserService {
    /**
     *
     * @param username
     * @return
     */
    User findByUsername(String username);


}
