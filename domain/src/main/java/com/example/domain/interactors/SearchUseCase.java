package com.example.domain.interactors;




import com.example.domain.entity.DataEntity;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.repository.DataRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class SearchUseCase extends BaseUseCase {
    private DataRepository dataRepository;

    @Inject
    public SearchUseCase(PostExecutionThread postExecutionThread, DataRepository dataRepository) {
        super(postExecutionThread);
        this.dataRepository = dataRepository;
    }

//    public Observable<List<DataEntity>> search(String keys){
//        return dataRepository.search(keys)
//                .subscribeOn(threadExecution)
//                .observeOn(postExecutionThread);
//    }
}
