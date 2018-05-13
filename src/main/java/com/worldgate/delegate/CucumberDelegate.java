package com.worldgate.delegate;

import cucumber.api.cli.Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CucumberDelegate {

    public void runCucumber(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		Main.main(new String[]{"-g", "trainerTab", "./src/main/resources/trainerTest.feature"});
//		Main.main(new String[]{"-g", "curriculaTab", "./src/main/resources/curriculaTest.feature"});
        Main.main(new String[]{"-g", "", "./src/test/resources/loginTest.feature"});

    }

//    public static void main(String[] args) throws Throwable {
//        Main.main(new String[]{"-g", "", "./src/test/resources/loginTest.feature"});
//    }

}



