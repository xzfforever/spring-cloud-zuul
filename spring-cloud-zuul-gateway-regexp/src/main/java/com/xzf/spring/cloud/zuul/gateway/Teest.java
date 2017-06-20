package com.xzf.spring.cloud.zuul.gateway;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/20.
 */
public class Teest {

    private static Pattern servicePattern = Pattern.compile("(?<name>^.+)-(?<subname>center)");

    private static String routePattern = "/${name}/${subname}/";

    public static void main(String args[]){
        String route = apply("user-center");

        System.out.println("user-center:-------->"+route);


    }

    public static String apply(String serviceId) {
        Matcher matcher = servicePattern.matcher(serviceId);
        String route = matcher.replaceFirst(routePattern);
        System.out.println(" route:"+route);
        route = cleanRoute(route);
        System.out.println(" clean route:"+route);
        return StringUtils.hasText(route)?route:serviceId;
    }

    private static String cleanRoute(String route) {
        String routeToClean = route.replaceAll("/{2,}", "/");
        if(routeToClean.startsWith("/")) {
            routeToClean = routeToClean.substring(1);
        }

        if(routeToClean.endsWith("/")) {
            routeToClean = routeToClean.substring(0, routeToClean.length() - 1);
        }

        return routeToClean;
    }


}
