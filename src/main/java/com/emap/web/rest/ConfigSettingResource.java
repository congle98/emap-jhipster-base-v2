package com.emap.web.rest;

import com.emap.repository.ConfigSettingRepository;
import com.emap.service.ConfigSettingService;
import com.emap.service.dto.ConfigSettingDTO;
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
 * REST controller for managing {@link com.emap.domain.ConfigSetting}.
 */
@RestController
@RequestMapping("/api")
public class ConfigSettingResource {

    private final Logger log = LoggerFactory.getLogger(ConfigSettingResource.class);

    private static final String ENTITY_NAME = "configSetting";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConfigSettingService configSettingService;

    private final ConfigSettingRepository configSettingRepository;

    public ConfigSettingResource(ConfigSettingService configSettingService, ConfigSettingRepository configSettingRepository) {
        this.configSettingService = configSettingService;
        this.configSettingRepository = configSettingRepository;
    }

    /**
     * {@code POST  /config-settings} : Create a new configSetting.
     *
     * @param configSettingDTO the configSettingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new configSettingDTO, or with status {@code 400 (Bad Request)} if the configSetting has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/config-settings")
    public ResponseEntity<ConfigSettingDTO> createConfigSetting(@Valid @RequestBody ConfigSettingDTO configSettingDTO)
        throws URISyntaxException {
        log.debug("REST request to save ConfigSetting : {}", configSettingDTO);
        if (configSettingDTO.getId() != null) {
            throw new BadRequestAlertException("A new configSetting cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ConfigSettingDTO result = configSettingService.save(configSettingDTO);
        return ResponseEntity
            .created(new URI("/api/config-settings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /config-settings/:id} : Updates an existing configSetting.
     *
     * @param id the id of the configSettingDTO to save.
     * @param configSettingDTO the configSettingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated configSettingDTO,
     * or with status {@code 400 (Bad Request)} if the configSettingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the configSettingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/config-settings/{id}")
    public ResponseEntity<ConfigSettingDTO> updateConfigSetting(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ConfigSettingDTO configSettingDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ConfigSetting : {}, {}", id, configSettingDTO);
        if (configSettingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, configSettingDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!configSettingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ConfigSettingDTO result = configSettingService.update(configSettingDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, configSettingDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /config-settings/:id} : Partial updates given fields of an existing configSetting, field will ignore if it is null
     *
     * @param id the id of the configSettingDTO to save.
     * @param configSettingDTO the configSettingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated configSettingDTO,
     * or with status {@code 400 (Bad Request)} if the configSettingDTO is not valid,
     * or with status {@code 404 (Not Found)} if the configSettingDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the configSettingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/config-settings/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConfigSettingDTO> partialUpdateConfigSetting(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ConfigSettingDTO configSettingDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ConfigSetting partially : {}, {}", id, configSettingDTO);
        if (configSettingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, configSettingDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!configSettingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConfigSettingDTO> result = configSettingService.partialUpdate(configSettingDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, configSettingDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /config-settings} : get all the configSettings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of configSettings in body.
     */
    @GetMapping("/config-settings")
    public ResponseEntity<List<ConfigSettingDTO>> getAllConfigSettings(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of ConfigSettings");
        Page<ConfigSettingDTO> page = configSettingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /config-settings/:id} : get the "id" configSetting.
     *
     * @param id the id of the configSettingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the configSettingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/config-settings/{id}")
    public ResponseEntity<ConfigSettingDTO> getConfigSetting(@PathVariable Long id) {
        log.debug("REST request to get ConfigSetting : {}", id);
        Optional<ConfigSettingDTO> configSettingDTO = configSettingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(configSettingDTO);
    }

    /**
     * {@code DELETE  /config-settings/:id} : delete the "id" configSetting.
     *
     * @param id the id of the configSettingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/config-settings/{id}")
    public ResponseEntity<Void> deleteConfigSetting(@PathVariable Long id) {
        log.debug("REST request to delete ConfigSetting : {}", id);
        configSettingService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
