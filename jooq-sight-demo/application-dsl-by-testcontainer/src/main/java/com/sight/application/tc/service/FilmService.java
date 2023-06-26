package com.sight.application.tc.service;

import com.sight.application.tc.repository.FilmJooqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

  private final FilmJooqRepository dao;

  public void test() {
//    dao.findById()
  }
}
