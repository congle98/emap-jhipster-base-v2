package com.emap.web.rest;

import com.emap.repository.CoordinatesDetailsRepository;
import com.emap.service.CoordinatesDetailsService;
import com.emap.service.dto.CoordinatesDetailsDTO;
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
 * REST controller for managing {@link com.emap.domain.CoordinatesDetails}.
 */
@RestController
@RequestMapping("/api")
public class CoordinatesDetailsResource {

    private final Logger log = LoggerFactory.getLogger(CoordinatesDetailsResource.class);

    private static final String ENTITY_NAME = "coordinatesDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CoordinatesDetailsService coordinatesDetailsService;

    private final CoordinatesDetailsRepository coordinatesDetailsRepository;

    public CoordinatesDetailsResource(
        CoordinatesDetailsService coordinatesDetailsService,
        CoordinatesDetailsRepository coordinatesDetailsRepository
    ) {
        this.coordinatesDetailsService = coordinatesDetailsService;
        this.coordinatesDetailsRepository = coordinatesDetailsRepository;
    }

    /**
     * {@code POST  /coordinates-details} : Create a new coordinatesDetails.
     *
     * @param coordinatesDetailsDTO the coordinatesDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new coordinatesDetailsDTO, or with status {@code 400 (Bad Request)} if the coordinatesDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/coordinates-details")
    public ResponseEntity<CoordinatesDetailsDTO> createCoordinatesDetails(@Valid @RequestBody CoordinatesDetailsDTO coordinatesDetailsDTO)
        throws URISyntaxException {
        log.debug("REST request to save CoordinatesDetails : {}", coordinatesDetailsDTO);
        if (coordinatesDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new coordinatesDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CoordinatesDetailsDTO result = coordinatesDetailsService.save(coordinatesDetailsDTO);
        return ResponseEntity
            .created(new URI("/api/coordinates-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /coordinates-details/:id} : Updates an existing coordinatesDetails.
     *
     * @param id the id of the coordinatesDetailsDTO to save.
     * @param coordinatesDetailsDTO the coordinatesDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated coordinatesDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the coordinatesDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the coordinatesDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/coordinates-details/{id}")
    public ResponseEntity<CoordinatesDetailsDTO> updateCoordinatesDetails(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CoordinatesDetailsDTO coordinatesDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CoordinatesDetails : {}, {}", id, coordinatesDetailsDTO);
        if (coordinatesDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, coordinatesDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!coordinatesDetailsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CoordinatesDetailsDTO result = coordinatesDetailsService.update(coordinatesDetailsDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, coordinatesDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /coordinates-details/:id} : Partial updates given fields of an existing coordinatesDetails, field will ignore if it is null
     *
     * @param id the id of the coordinatesDetailsDTO to save.
     * @param coordinatesDetailsDTO the coordinatesDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated coordinatesDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the coordinatesDetailsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the coordinatesDetailsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the coordinatesDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/coordinates-details/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CoordinatesDetailsDTO> partialUpdateCoordinatesDetails(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CoordinatesDetailsDTO coordinatesDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CoordinatesDetails partially : {}, {}", id, coordinatesDetailsDTO);
        if (coordinatesDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, coordinatesDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!coordinatesDetailsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CoordinatesDetailsDTO> result = coordinatesDetailsService.partialUpdate(coordinatesDetailsDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, coordinatesDetailsDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /coordinates-details} : get all the coordinatesDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of coordinatesDetails in body.
     */
    @GetMapping("/coordinates-details")
    public ResponseEntity<List<CoordinatesDetailsDTO>> getAllCoordinatesDetails(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of CoordinatesDetails");
        Page<CoordinatesDetailsDTO> page = coordinatesDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /coordinates-details/:id} : get the "id" coordinatesDetails.
     *
     * @param id the id of the coordinatesDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the coordinatesDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/coordinates-details/{id}")
    public ResponseEntity<CoordinatesDetailsDTO> getCoordinatesDetails(@PathVariable Long id) {
        log.debug("REST request to get CoordinatesDetails : {}", id);
        Optional<CoordinatesDetailsDTO> coordinatesDetailsDTO = coordinatesDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(coordinatesDetailsDTO);
    }

    /**
     * {@code DELETE  /coordinates-details/:id} : delete the "id" coordinatesDetails.
     *
     * @param id the id of the coordinatesDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/coordinates-details/{id}")
    public ResponseEntity<Void> deleteCoordinatesDetails(@PathVariable Long id) {
        log.debug("REST request to delete CoordinatesDetails : {}", id);
        coordinatesDetailsService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
