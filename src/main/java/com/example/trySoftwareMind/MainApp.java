package com.example.trySoftwareMind;

import com.example.trySoftwareMind.balancer.BalanceService;
import com.example.trySoftwareMind.balancer.Balancer;
import com.example.trySoftwareMind.model.Member;
import com.example.trySoftwareMind.model.Team;

import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<Member> people = Arrays.asList(
                new Member("Johnny", 8),
                new Member("Robbie", 5),
                new Member("Juliet", 3),
                new Member("Scarlet", 5),
                new Member("Jude", 9),
                new Member("Deborah", 6)
        );

        int numberOfTeams = 3;

        BalanceService balancer = new Balancer();
        List<Team> teams = balancer.balanceTeams(people, numberOfTeams);
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team no " + (i + 1) + " " + teams.get(i).toString());
        }
        double mean = teams.stream().mapToDouble(Team::averageRate).average().orElse(0);
        double variance = teams.stream().mapToDouble(team -> Math.pow(team.averageRate() - mean, 2)).sum() / teams.size();
        double stdDev = Math.sqrt(variance);

        System.out.printf("Teams rate standard deviation: %.2f%n", stdDev);
    }
}
