package com.example.trySoftwareMind.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public List<Member> members;

    public Team() {
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public double averageRate() {
        if (members.isEmpty()) return 0;
        int sum = members.stream().mapToInt(Member::getRate).sum();
        return sum / (double) members.size();
    }

    @Override
    public String toString() {
        String names = String.join(", ", members.stream().map(Member::getName).toArray(String[]::new));
        return "Team has " + members.size() + " players (" + names + "). Average rate: " + averageRate();
    }
}
