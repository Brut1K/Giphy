package com.example.domain.repository;


import com.example.domain.entity.DataEntity;


import java.util.List;

import io.reactivex.Observable;

public interface DataRepository {

    Observable<List<DataEntity>> loadTrends();

}
