package com.example.w15d2.Entities.Service;

import com.example.w15d2.Entities.Blogpost;
import com.example.w15d2.Payload.BlogpostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogpostService {
    private List<Blogpost> blogpostList = new ArrayList<>();

    public List<Blogpost> findAll() {
        return this.blogpostList;
    }

    public Blogpost saveBlogpost(BlogpostPayload body) {
        Random rndm = new Random();
        Blogpost newBlogpost = new Blogpost(body.titolo(), body.categoria(), body.cover(), body.contenuto(), body.tempoDiLettura());
        Blogpost.setId(rndm.nextInt(1, 10000));
        this.blogpostList.add(newBlogpost);
        return newBlogpost;
    }

    public Blogpost findById(int BlogpostId) throws Exception {
        Blogpost found = null;
        for (Blogpost post : this.blogpostList) {
            if (post.id() == BlogpostId) found = post;
        }
        if (found == null) throw new Exception();
        return found;
    }

    public Blogpost findByIdAndUpdate(int BlogpostId, BlogpostPayload body) throws Exception {
        Blogpost found = null;
        for (Blogpost post : this.blogpostList) {
            if (post.id() == BlogpostId) {
                found = post;
                found.setCategoria(body.categoria());
                found.setCover(body.cover());
                found.setTitolo(body.titolo());
                found.setContenuto(body.contenuto());
                found.setCategoria(body.categoria());
            }
        }
        if (found == null) throw new Exception();
        return found;
    }

    public void findByIdAndDelete(int BlogpostId) throws Exception {
        Blogpost found = null;
        for (Blogpost post : this.blogpostList) {
            if (post.id() == BlogpostId) found = post;
        }
        if (found == null) throw new Exception();
        this.blogpostList.remove(found);
    }
}
