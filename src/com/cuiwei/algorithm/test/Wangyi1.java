package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/8
 */
public class Wangyi1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Vote> votes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int s = sc.nextInt();
            votes.add(new Vote(p, s));
        }
        System.out.println(fun(votes, m));
    }

    public static int fun(List<Vote> votes, int n) {
        Collections.sort(votes);
        int[] tickets = new int[3001];
        int numOfwin = (n & 1) == 1 ? n / 2 + 1 : n / 2;
        int maxTickets = 0;
        int maxPerson = 0;
        for (int i = 0; i < votes.size(); i++) {
            int index = votes.get(i).person;
            int ticket = ++tickets[index];
            if (ticket > maxTickets) {
                maxTickets = ticket;
                maxPerson = index;
            }
        }
        int ticketsOf1 = tickets[1];
        if (ticketsOf1 > numOfwin) return 0;
        int numOfSuger = 0;
        for (int i = 0; i < votes.size() ; i++) {
            Vote vote = votes.get(i);
            if (vote.person != 1){
                if (vote.person == maxPerson){
                    maxTickets--;
                }
                numOfSuger += vote.suger;
                ticketsOf1++;
                if (ticketsOf1 > maxTickets){
                    return numOfSuger;
                }
            }
        }
        return 0;
    }

    private static class Vote implements Comparable<Vote> {
        int person;
        int suger;

        Vote(int person, int suger) {
            this.person = person;
            this.suger = suger;
        }

        @Override
        public int compareTo(Vote o) {
            return this.suger - o.suger;
        }
    }
}
