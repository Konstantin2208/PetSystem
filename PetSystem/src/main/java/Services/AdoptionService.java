package Services;

import Repositorys.AdoptionRepo;
import models.AdoptionPost;

public class AdoptionService {
    private final AdoptionRepo repo;

public AdoptionService(AdoptionRepo repo) {
    this.repo = repo;
}

public String createPost(AdoptionPost post) {
    if (post.getTitle() == null || post.getTitle().isEmpty()) {
        return "Заглавието е задължително поле";
    }
    repo.save(post);
    return "Обявата е запазена и очаква одобрение";
}

public String approvePost(AdoptionPost post) {
    post.setStatus("одобрена");
    return "Обявата е одобрена";
}

public String rejectPost(AdoptionPost post) {
    post.setStatus("отхвърлена");
    return "Обявата е отхвърлена";
}
}