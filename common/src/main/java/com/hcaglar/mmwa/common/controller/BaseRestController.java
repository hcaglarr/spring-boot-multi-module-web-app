package com.hcaglar.mmwa.common.controller;



import com.hcaglar.mmwa.common.dto.BaseDTO;
import com.hcaglar.mmwa.common.dto.response.PageableDTOResponse;
import com.hcaglar.mmwa.common.entity.BaseEntity;
import com.hcaglar.mmwa.common.mapper.BaseMapper;
import com.hcaglar.mmwa.common.pageable.Pageable;
import com.hcaglar.mmwa.common.repository.BaseRepository;
import com.hcaglar.mmwa.common.response.BaseResponseEntity;
import com.hcaglar.mmwa.common.service.BaseRestService;
import com.hcaglar.mmwa.common.service.BaseService;
import com.hcaglar.mmwa.common.util.PageableUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hcaglar.mmwa.common.constant.PathConstant.ENTITY_ID;
import static com.hcaglar.mmwa.common.constant.PathConstant.PAGING;
import static com.hcaglar.mmwa.common.util.BaseEntityUtil.swap;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public abstract class BaseRestController<IdType, Entity extends BaseEntity, RequestDTO extends BaseDTO, ResponseDTO extends BaseDTO, Mapper extends BaseMapper<RequestDTO, ResponseDTO, Entity, PageableDTOResponse<ResponseDTO>>, Repository extends BaseRepository<Entity, IdType>, Service extends BaseRestService<Entity, IdType>> extends BaseResponseEntity<ResponseDTO> {

    protected abstract Service getService();

    protected abstract Mapper getMapper();

    @PostMapping(PAGING)
    protected ResponseEntity<PageImpl<ResponseDTO>> index(@RequestBody Pageable<RequestDTO> pageable){

        var entities = getService().findAll(pageable);
        var responseDTOS = getMapper().toEntites(entities.getContent());
        var response = new PageImpl<>(responseDTOS, PageableUtil.createPageRequest(pageable),responseDTOS.size());

        return responseEntity(response);
    }

    @GetMapping(ENTITY_ID)
    protected ResponseEntity<ResponseDTO> show(@PathVariable IdType id){
        return responseEntity(this.getMapper().toResponse(this.getService().get(id)));
    }

    @PostMapping
    protected ResponseEntity<ResponseDTO> save(@RequestBody RequestDTO requestDTO){

        Entity entity = this.getMapper().toEntity(requestDTO);
        Entity newRegisteredEntity = this.getService().save(entity);

        return responseEntity(this.getMapper().toResponse(newRegisteredEntity));
    }

    @PutMapping(ENTITY_ID)
    protected ResponseEntity<ResponseDTO> update(@RequestBody RequestDTO requestDTO, @PathVariable IdType id){

        Entity entity = this.getService().get(id);
        Entity newEntity = this.getMapper().toEntity(requestDTO);

        swap(entity, newEntity);

        Entity updatedEntity = this.getService().update(newEntity, id);

        return responseEntity(this.getMapper().toResponse(updatedEntity), CREATED);
    }

    @ResponseStatus(OK)
    @DeleteMapping(ENTITY_ID)
    protected void delete(@PathVariable IdType id){
        Entity entity = this.getService().get(id);
        this.getService().delete(entity);
    }

}
