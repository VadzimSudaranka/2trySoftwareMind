package com.example.trySoftwareMind.balancer;

import com.example.trySoftwareMind.model.Member;
import com.example.trySoftwareMind.model.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Balancer implements BalanceService {

    @Override
    public List<Team> balanceTeams(List<Member> members, int numberOfTeams) {
        members.sort(Comparator.comparingInt(Member::getRate).reversed());

        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < numberOfTeams; i++) {
            teams.add(new Team());
        }

        for (int i = 0; i < members.size(); i++) {
            teams.get(i % numberOfTeams).addMember(members.get(i));
        }

        return teams;
    }
}
