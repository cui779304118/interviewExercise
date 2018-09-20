package com.cuiwei.algorithm.leetcode;

import java.util.*;

/**
 * created by cuiwei on 2018/9/19
 * 子域名访问计数
 * https://leetcode-cn.com/problems/subdomain-visit-count/description/
 */
public class SubDomainVisits {

    public List<String> fun(String[] cpdomains) {
        List<String> results = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return results;
        Map<String, Integer> domainMap = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] visitsAndDomains = cpdomains[i].split(" ");
            int visits = Integer.valueOf(visitsAndDomains[0]);
            String[] domains = parseDomains(visitsAndDomains[1]);
            for (int j = 0; j < domains.length; j++) {
                String key = domains[j];
                if (domainMap.containsKey(key)) {
                    int tempVisits = domainMap.get(key);
                    domainMap.put(key, tempVisits + visits);
                } else {
                    domainMap.put(key, visits);
                }
            }
        }
        results = iterateMap(domainMap);
        return results;
    }

    private String[] parseDomains(String domain) {
        String[] tempDomains = domain.split("\\.");
        int len = tempDomains.length;
        String[] domains = new String[len];
        domains[len - 1] = tempDomains[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            domains[i] = tempDomains[i] + "." + domains[i + 1];
        }
        return domains;
    }

    private List<String> iterateMap(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            String domain = entry.getKey();
            String visits = String.valueOf(entry.getValue());
            list.add(visits + " " + domain);
        }
        return list;
    }

    public static void main(String[] args) {
        SubDomainVisits domainVisits = new SubDomainVisits();
        String[] domains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = domainVisits.fun(domains);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
