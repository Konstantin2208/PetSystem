package Repositorys;

import models.AdoptionPost;

import java.util.List;

public interface IAdoptionRepo {
    void save(AdoptionPost post);
    List<AdoptionPost> getPendingPosts();
}
