package com.example.trySoftwareMind.balancer;

import com.example.trySoftwareMind.model.Member;
import com.example.trySoftwareMind.model.Team;

import java.util.List;

public interface BalanceService {
    List<Team> balanceTeams(List<Member> persons, int numberOfTeams);
}
