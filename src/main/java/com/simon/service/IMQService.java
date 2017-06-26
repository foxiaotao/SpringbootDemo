package com.simon.service;

/**
 * Created by xiaotao on 2017/5/18.
 */
public interface IMQService {
    void send(String message);
    void send(Long loanId, Long loanProgress,Long termNo);
}
