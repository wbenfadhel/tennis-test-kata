package com.atn.kata.services;

import com.atn.kata.domain.Match;
import com.atn.kata.domain.Player;

public interface TennisGameService {

    Match addPoint(Match match, Player player);
}
