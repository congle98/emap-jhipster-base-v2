package com.emap.web.rest;

import com.emap.repository.WarningMessageRepository;
import com.emap.service.WarningMessageService;
import com.emap.service.dto.WarningMessageDTO;
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
 * REST controller for managing {@link com.emap.domain.WarningMessage}.
 */
@RestController
@RequestMapping("/api")
public class WarningMessageResource {

    private final Logger log = LoggerFactory.getLogger(WarningMessageResource.class);

    private static final String ENTITY_NAME = "warningMessage";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WarningMessageService warningMessageService;

    private final WarningMessageRepository warningMessageRepository;

    public WarningMessageResource(WarningMessageService warningMessageService, WarningMessageRepository warningMessageRepository) {
        this.warningMessageService = warningMessageService;
        this.warningMessageRepository = warningMessageRepository;
    }

    /**
     * {@code POST  /warning-messages} : Create a new warningMessage.
     *
     * @param warningMessageDTO the warningMessageDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new warningMessageDTO, or with status {@code 400 (Bad Request)} if the warningMessage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/warning-messages")
    public ResponseEntity<WarningMessageDTO> createWarningMessage(@Valid @RequestBody WarningMessageDTO warningMessageDTO)
        throws URISyntaxException {
        log.debug("REST request to save WarningMessage : {}", warningMessageDTO);
        if (warningMessageDTO.getId() != null) {
            throw new BadRequestAlertException("A new warningMessage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WarningMessageDTO result = warningMessageService.save(warningMessageDTO);
        return ResponseEntity
            .created(new URI("/api/warning-messages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /warning-messages/:id} : Updates an existing warningMessage.
     *
     * @param id the id of the warningMessageDTO to save.
     * @param warningMessageDTO the warningMessageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated warningMessageDTO,
     * or with status {@code 400 (Bad Request)} if the warningMessageDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the warningMessageDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/warning-messages/{id}")
    public ResponseEntity<WarningMessageDTO> updateWarningMessage(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody WarningMessageDTO warningMessageDTO
    ) throws URISyntaxException {
        log.debug("REST request to update WarningMessage : {}, {}", id, warningMessageDTO);
        if (warningMessageDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, warningMessageDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!warningMessageRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        WarningMessageDTO result = warningMessageService.update(warningMessageDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, warningMessageDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /warning-messages/:id} : Partial updates given fields of an existing warningMessage, field will ignore if it is null
     *
     * @param id the id of the warningMessageDTO to save.
     * @param warningMessageDTO the warningMessageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated warningMessageDTO,
     * or with status {@code 400 (Bad Request)} if the warningMessageDTO is not valid,
     * or with status {@code 404 (Not Found)} if the warningMessageDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the warningMessageDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/warning-messages/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<WarningMessageDTO> partialUpdateWarningMessage(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody WarningMessageDTO warningMessageDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update WarningMessage partially : {}, {}", id, warningMessageDTO);
        if (warningMessageDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, warningMessageDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!warningMessageRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<WarningMessageDTO> result = warningMessageService.partialUpdate(warningMessageDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, warningMessageDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /warning-messages} : get all the warningMessages.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of warningMessages in body.
     */
    @GetMapping("/warning-messages")
    public ResponseEntity<List<WarningMessageDTO>> getAllWarningMessages(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of WarningMessages");
        Page<WarningMessageDTO> page = warningMessageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /warning-messages/:id} : get the "id" warningMessage.
     *
     * @param id the id of the warningMessageDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the warningMessageDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/warning-messages/{id}")
    public ResponseEntity<WarningMessageDTO> getWarningMessage(@PathVariable Long id) {
        log.debug("REST request to get WarningMessage : {}", id);
        Optional<WarningMessageDTO> warningMessageDTO = warningMessageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(warningMessageDTO);
    }

    /**
     * {@code DELETE  /warning-messages/:id} : delete the "id" warningMessage.
     *
     * @param id the id of the warningMessageDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/warning-messages/{id}")
    public ResponseEntity<Void> deleteWarningMessage(@PathVariable Long id) {
        log.debug("REST request to delete WarningMessage : {}", id);
        warningMessageService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
