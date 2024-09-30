package sansam.team.major.command.application.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sansam.team.major.command.application.dto.MajorDTO;
import sansam.team.major.command.domain.aggregate.Major;
import sansam.team.major.command.domain.repository.MajorRepository;

@Service
public class MajorService {

    private final MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public void createMajor(MajorDTO dto) {
        Major major = new Major();
        major.updateFrom(dto);
        majorRepository.save(major);
    }

    public void updateMajor(Long majorSeq, MajorDTO dto) {
        Major major = majorRepository.findById(majorSeq)
                .orElseThrow(() -> new EntityNotFoundException("Major not found"));
        major.updateFrom(dto);
        majorRepository.save(major);
    }

    public void deleteMajor(Long majorSeq) {
        Major major = majorRepository.findById(majorSeq)
                .orElseThrow(() -> new EntityNotFoundException("Major not found"));
        majorRepository.delete(major);
    }
}
