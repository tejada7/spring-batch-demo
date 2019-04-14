package com.example.demospringbatch.tasks;

import com.example.demospringbatch.BatchConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que gestiona la ejecución automatizada de jobs.
 */
@Component
public class JobTask {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    /**
     * Constantes relacionadas al logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(JobTask.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Ejecuta el job encontrado en la clase {@link BatchConfiguration#importPersonaJob} cada 10 segundos.
     *
     * @throws Exception si algún error suscita durante el procesamiento del job
     */
    @Scheduled(fixedRate = 10000)
    public void executeJob() throws Exception {
        LOG.info("Inicio ejecución de job... {}", LocalDateTime.now().format(FORMATTER));
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
        jobLauncher.run(job, jobParameters);
        LOG.info("Job {} finalizado... {}", job.getName(), LocalDateTime.now().format(FORMATTER));
    }
}
