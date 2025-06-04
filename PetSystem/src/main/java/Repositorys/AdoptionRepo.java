package Repositorys;

import models.AdoptionPost;

import java.util.ArrayList;
import java.util.List;

public class AdoptionRepo implements IAdoptionRepo{
    public List<AdoptionPost> posts = new ArrayList<>();
    @Override
    public void save(AdoptionPost post) {
        posts.add(post);
    }

    @Override
    public List<AdoptionPost> getPendingPosts() {
        List<AdoptionPost> result = new ArrayList<>();
        for (AdoptionPost post : posts) {
            if (post.getStatus().equals("pending")) {
                result.add(post);
            }
        }
        return result;
    }
}
