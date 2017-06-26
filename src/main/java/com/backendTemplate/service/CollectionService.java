package com.backendTemplate.service;

import com.backendTemplate.dao.CollectionDAO;
import com.backendTemplate.entity.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/25.
 */

@Repository
@Transactional
public class CollectionService {

    @Autowired
    private CollectionDAO collectionDAO;

    public void setCollectionDAO(CollectionDAO collectionDAO) {
        this.collectionDAO = collectionDAO;
    }

    public List<Collection> showCollectBooks(int collectorID) {
        return this.collectionDAO.showCollectedBook(collectorID);
    }

    public List<Collection> checkIsCollect(int collectorID, int bookID){
        return this.collectionDAO.checkIsCollect(collectorID, bookID);
    }
}
