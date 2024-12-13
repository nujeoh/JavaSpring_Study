package com.example.cryptoautomation.repository;

import com.example.cryptoautomation.entity.ReportHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReportHistoryRepository{
    public final ReportHistoryJpaRepository repository;

    public void save(String market, String price){
        repository.save(
                new ReportHistory(market, price)
        );
    }
}
