package com.emap.web.rest;

import com.emap.repository.CoordinatesRepository;
import com.emap.service.CoordinatesService;
import com.emap.service.dto.CoordinatesDTO;
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
 * REST controller for managing {@link com.emap.domain.Coordinates}.
 */
@RestController
@RequestMapping("/api")
public class CoordinatesResource {

    private final Logger log = LoggerFactory.getLogger(CoordinatesResource.class);

    private static final String ENTITY_NAME = "coordinates";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CoordinatesService coordinatesService;

    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesResource(CoordinatesService coordinatesService, CoordinatesRepository coordinatesRepository) {
        this.coordinatesService = coordinatesService;
        this.coordinatesRepository = coordinatesRepository;
    }

    /**
     * {@code POST  /coordinates} : Create a new coordinates.
     *
     * @param coordinatesDTO the coordinatesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new coordinatesDTO, or with status {@code 400 (Bad Request)} if the coordinates has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/coordinates")
    public ResponseEntity<CoordinatesDTO> createCoordinates(@Valid @RequestBody CoordinatesDTO coordinatesDTO) throws URISyntaxException {
        log.debug("REST request to save Coordinates : {}", coordinatesDTO);
        if (coordinatesDTO.getId() != null) {
            throw new BadRequestAlertException("A new coordinates cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CoordinatesDTO result = coordinatesService.save(coordinatesDTO);
        return ResponseEntity
            .created(new URI("/api/coordinates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /coordinates/:id} : Updates an existing coordinates.
     *
     * @param id the id of the coordinatesDTO to save.
     * @param coordinatesDTO the coordinatesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated coordinatesDTO,
     * or with status {@code 400 (Bad Request)} if the coordinatesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the coordinatesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/coordinates/{id}")
    public ResponseEntity<CoordinatesDTO> updateCoordinates(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CoordinatesDTO coordinatesDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Coordinates : {}, {}", id, coordinatesDTO);
        if (coordinatesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, coordinatesDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!coordinatesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CoordinatesDTO result = coordinatesService.update(coordinatesDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, coordinatesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /coordinates/:id} : Partial updates given fields of an existing coordinates, field will ignore if it is null
     *
     * @param id the id of the coordinatesDTO to save.
     * @param coordinatesDTO the coordinatesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated coordinatesDTO,
     * or with status {@code 400 (Bad Request)} if the coordinatesDTO is not valid,
     * or with status {@code 404 (Not Found)} if the coordinatesDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the coordinatesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/coordinates/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CoordinatesDTO> partialUpdateCoordinates(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CoordinatesDTO coordinatesDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Coordinates partially : {}, {}", id, coordinatesDTO);
        if (coordinatesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, coordinatesDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!coordinatesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CoordinatesDTO> result = coordinatesService.partialUpdate(coordinatesDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, coordinatesDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /coordinates} : get all the coordinates.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of coordinates in body.
     */
    @GetMapping("/coordinates")
    public ResponseEntity<List<CoordinatesDTO>> getAllCoordinates(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Coordinates");
        Page<CoordinatesDTO> page = coordinatesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /coordinates/:id} : get the "id" coordinates.
     *
     * @param id the id of the coordinatesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the coordinatesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/coordinates/{id}")
    public ResponseEntity<CoordinatesDTO> getCoordinates(@PathVariable Long id) {
        log.debug("REST request to get Coordinates : {}", id);
        Optional<CoordinatesDTO> coordinatesDTO = coordinatesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(coordinatesDTO);
    }

    /**
     * {@code DELETE  /coordinates/:id} : delete the "id" coordinates.
     *
     * @param id the id of the coordinatesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/coordinates/{id}")
    public ResponseEntity<Void> deleteCoordinates(@PathVariable Long id) {
        log.debug("REST request to delete Coordinates : {}", id);
        coordinatesService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
