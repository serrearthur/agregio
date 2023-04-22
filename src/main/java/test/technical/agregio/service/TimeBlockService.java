package test.technical.agregio.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.technical.agregio.dao.TimeBlockDao;
import test.technical.agregio.model.TimeBlock;
import test.technical.agregio.model.dto.creation.TimeBlockCreationDto;
import test.technical.agregio.model.mapper.TimeBlockMapper;

@Service
@Transactional
@RequiredArgsConstructor //needed for constructor dependency injection
public class TimeBlockService {
    private final TimeBlockDao timeBlockDao;
    private final TimeBlockMapper timeBlockMapper;

    public TimeBlock createTimeBlock(TimeBlockCreationDto dto) {
        return timeBlockDao.save(timeBlockMapper.creationDtoToTimeBlock(dto));
    }
}
