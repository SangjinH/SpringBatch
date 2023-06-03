package com.example.config;

import com.example.service.SecondTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobForTasklet {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final SecondTasklet secondTasklet;

    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("First Job ")
                .start(firstStep())
                .next(secondStep())
                .build();
    }

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("First Step")
                .tasklet(firstTask())
                .build();
    }

    private Tasklet firstTask() {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("This is First Tasklet Step!!");
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Step secondStep() {
        return stepBuilderFactory.get("Second Step")
                .tasklet(secondTasklet)
                .build();
    }

//    private Tasklet secondTask() {
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("This is Second Tasklet Step!!");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }

}
