package com.learning.practice.service;

import com.learning.practice.base.Common;
import com.learning.practice.base.IService;

import java.util.Map;

public interface ICommonService extends IService<Common, String> {
    Common findMaxSequence(Map<String, Object> params);
}
