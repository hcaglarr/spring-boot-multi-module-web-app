package com.hcaglar.mmwa.common.controller;

import com.hcaglar.mmwa.common.dto.BaseDTO;
import com.hcaglar.mmwa.common.dto.response.PageableDTOResponse;
import com.hcaglar.mmwa.common.entity.BaseEntity;
import com.hcaglar.mmwa.common.mapper.BaseMapper;
import com.hcaglar.mmwa.common.paths.BasePath;
import com.hcaglar.mmwa.common.response.BaseResponseEntity;
import com.hcaglar.mmwa.common.service.BaseService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.hcaglar.mmwa.common.constant.PathConstant.*;
import static com.hcaglar.mmwa.common.util.BaseEntityUtil.swap;

public abstract class BaseController<Paths extends BasePath, IdType, Entity extends BaseEntity, RequestDTO extends BaseDTO, ResponseDTO extends BaseDTO, Mapper extends BaseMapper<RequestDTO, ResponseDTO, Entity, PageableDTOResponse<Response>>, Service extends BaseService<Entity, IdType>> extends BaseResponseEntity<ResponseDTO> {

    protected abstract Entity getEntity();

    protected abstract Service getService();

    protected abstract Mapper getMapper();

    protected abstract Paths getPaths();


    @GetMapping
    protected String index(@RequestParam(name = "page", defaultValue = "1") Integer currentPage, Model model) {

        PageRequest pageRequest = PageRequest.of(currentPage - 1, 6);

        Page<Entity> entityPage = this.getService().getRepository().findAll(pageRequest);

        model.addAttribute("data", entityPage);
        model.addAttribute("currentPage", currentPage);

        return getPaths().getIndex();
    }

    @GetMapping("/new")
    protected String newMap(Model model) {
        model.addAttribute("data", getEntity());
        return getPaths().getNew();
    }

    @GetMapping("/edit/{id}")
    protected String edit(@PathVariable IdType id, Model model) {
        model.addAttribute("data", getService().get(id));
        return getPaths().getEdit();
    }

    @GetMapping(ENTITY_ID)
    protected String show(@PathVariable IdType id, Model model) {
        ResponseDTO response = this.getMapper().toResponse(this.getService().get(id));

        model.addAttribute("data", response);

        return getPaths().getRedirectIndex();
    }

    @PostMapping
    protected String save(@Valid @ModelAttribute RequestDTO requestDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return getPaths().getRedirectNew();
        }

        Entity entity = this.getMapper().toEntity(requestDTO);
        Entity newRegisteredEntity = this.getService().save(entity);

        ResponseDTO responseDTO = this.getMapper().toResponse(newRegisteredEntity);

        model.addAttribute("data", responseDTO);

        return getPaths().getRedirectIndex();
    }

    @PostMapping(UPDATE_ENTITY_ID)
    protected String update(@Valid @ModelAttribute RequestDTO requestDTO, BindingResult result, @PathVariable IdType id, Model model) {

        if (result.hasErrors()) {
            return getPaths().getRedirectUpdate();
        }

        Entity entity = this.getService().get(id);
        Entity newEntity = this.getMapper().toEntity(requestDTO);

        swap(entity, newEntity);

        Entity updatedEntity = this.getService().update(newEntity, id);

        ResponseDTO responseDTO = this.getMapper().toResponse(updatedEntity);

        model.addAttribute("data", responseDTO);

        return getPaths().getRedirectIndex();
    }

    @PostMapping(DELETE_ENTITY_ID)
    protected String delete(@PathVariable IdType id) {
        Entity entity = this.getService().get(id);
        this.getService().delete(entity);

        return getPaths().getRedirectIndex();
    }

}
