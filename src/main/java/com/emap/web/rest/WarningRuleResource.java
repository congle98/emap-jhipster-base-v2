package com.emap.web.rest;

import com.emap.repository.WarningRuleRepository;
import com.emap.service.WarningRuleService;
import com.emap.service.dto.WarningRuleDTO;
import com.emap.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.emap.domain.WarningRule}.
 */
@RestController
@RequestMapping("/api")
public class WarningRuleResource {

    private final Logger log = LoggerFactory.getLogger(WarningRuleResource.class);

    private static final String ENTITY_NAME = "warningRule";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WarningRuleService warningRuleService;

    private final WarningRuleRepository warningRuleRepository;

    public WarningRuleResource(WarningRuleService warningRuleService, WarningRuleRepository warningRuleRepository) {
        this.warningRuleService = warningRuleService;
        this.warningRuleRepository = warningRuleRepository;
    }

    /**
     * {@code POST  /warning-rules} : Create a new warningRule.
     *
     * @param warningRuleDTO the warningRuleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new warningRuleDTO, or with status {@code 400 (Bad Request)} if the warningRule has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/warning-rules")
    public ResponseEntity<WarningRuleDTO> createWarningRule(@Valid @RequestBody WarningRuleDTO warningRuleDTO) throws URISyntaxException {
        log.debug("REST request to save WarningRule : {}", warningRuleDTO);
        if (warningRuleDTO.getId() != null) {
            throw new BadRequestAlertException("A new warningRule cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WarningRuleDTO result = warningRuleService.save(warningRuleDTO);
        return ResponseEntity
            .created(new URI("/api/warning-rules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /warning-rules/:id} : Updates an existing warningRule.
     *
     * @param id the id of the warningRuleDTO to save.
     * @param warningRuleDTO the warningRuleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated warningRuleDTO,
     * or with status {@code 400 (Bad Request)} if the warningRuleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the warningRuleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/warning-rules/{id}")
    public ResponseEntity<WarningRuleDTO> updateWarningRule(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody WarningRuleDTO warningRuleDTO
    ) throws URISyntaxException {
        log.debug("REST request to update WarningRule : {}, {}", id, warningRuleDTO);
        if (warningRuleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, warningRuleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!warningRuleRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        WarningRuleDTO result = warningRuleService.update(warningRuleDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, warningRuleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /warning-rules/:id} : Partial updates given fields of an existing warningRule, field will ignore if it is null
     *
     * @param id the id of the warningRuleDTO to save.
     * @param warningRuleDTO the warningRuleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated warningRuleDTO,
     * or with status {@code 400 (Bad Request)} if the warningRuleDTO is not valid,
     * or with status {@code 404 (Not Found)} if the warningRuleDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the warningRuleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/warning-rules/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<WarningRuleDTO> partialUpdateWarningRule(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody WarningRuleDTO warningRuleDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update WarningRule partially : {}, {}", id, warningRuleDTO);
        if (warningRuleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, warningRuleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!warningRuleRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<WarningRuleDTO> result = warningRuleService.partialUpdate(warningRuleDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, warningRuleDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /warning-rules} : get all the warningRules.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of warningRules in body.
     */
    @GetMapping("/warning-rules")
    public ResponseEntity<List<WarningRuleDTO>> getAllWarningRules(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of WarningRules");
        Page<WarningRuleDTO> page = warningRuleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /warning-rules/:id} : get the "id" warningRule.
     *
     * @param id the id of the warningRuleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the warningRuleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/warning-rules/{id}")
    public ResponseEntity<WarningRuleDTO> getWarningRule(@PathVariable Long id) {
        log.debug("REST request to get WarningRule : {}", id);
        Optional<WarningRuleDTO> warningRuleDTO = warningRuleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(warningRuleDTO);
    }

    /**
     * {@code DELETE  /warning-rules/:id} : delete the "id" warningRule.
     *
     * @param id the id of the warningRuleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/warning-rules/{id}")
    public ResponseEntity<Void> deleteWarningRule(@PathVariable Long id) {
        log.debug("REST request to delete WarningRule : {}", id);
        warningRuleService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
