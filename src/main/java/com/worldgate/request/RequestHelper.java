package com.worldgate.request;

import com.worldgate.delegate.CucumberDelegate;
import com.worldgate.util.LogUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

    private static CucumberDelegate cucumber = new CucumberDelegate();

    public static void process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        /*Get request*/
        String cases = request.getRequestURI().substring(16);
        LogUtil.log.info("CASES INFO: " + cases);

        //Changing between controllers
        switch (cases) {
            case "runCucumber.do":
                LogUtil.log.info("HITS CUCUMBER");
                cucumber.runCucumber();
                break;
            default:
                break;
        }
    }
}
