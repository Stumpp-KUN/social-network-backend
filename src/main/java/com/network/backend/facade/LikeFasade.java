package com.network.backend.facade;

import com.network.backend.dto.like.LikeDTOForCreateOrRead;
import com.network.backend.dto.like.LikeDTOForUpdate;
import com.network.backend.exception.NoSuchLike;
import com.network.backend.model.Like;
import com.network.backend.service.LikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeFasade {
    private LikeService likeService;

    public LikeFasade(LikeService likeService) {
        this.likeService = likeService;
    }

    public LikeDTOForCreateOrRead saveLike(LikeDTOForCreateOrRead like){
        Like like1=likeService.saveLike(getLikeByDTO(like));
        return getDTObyEntity(like1);
    }

    public int getLikeByUserId(long id){
        return likeService.getLikes(id);
    }

    private Like getLikeByDTO(LikeDTOForCreateOrRead like){
        Like like1=like.getEntity();
        return like1;
    }

    private LikeDTOForCreateOrRead getDTObyEntity(Like like){
        LikeDTOForCreateOrRead likeDTOForCreateOrRead=new LikeDTOForCreateOrRead(like);
        return likeDTOForCreateOrRead;
    }


    public LikeDTOForCreateOrRead getLike(long id){
        Like like=likeService.getLike(id);
        if(like==null) throw new NoSuchLike("There is not like with id "+id);
        return getDTObyEntity(like);
    }

    public LikeDTOForUpdate updateLike(LikeDTOForUpdate update){
        Like like=likeService.updateLike(getEntityByUpdateDTO(update));
        return getUpdateDTOByEntity(like);
    }

    private Like getEntityByUpdateDTO(LikeDTOForUpdate dto){
        Like like = dto.getEntity();
        return like;
    }

    private LikeDTOForUpdate getUpdateDTOByEntity(Like like){
        LikeDTOForUpdate likeDTOForUpdate=new LikeDTOForUpdate(like);
        return likeDTOForUpdate;
    }

    public void deleteLike(long id){
        if(likeService.getLike(id)==null) throw new NoSuchLike("There is no like with id "+id);
        likeService.deleteLike(id);
    }
}
