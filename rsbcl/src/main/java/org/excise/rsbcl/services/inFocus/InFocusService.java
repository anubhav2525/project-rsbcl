package org.excise.rsbcl.services.inFocus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.excise.rsbcl.model.inFocus.InFocus;
import org.excise.rsbcl.repository.inFocus.InFocusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InFocusService {
    @Autowired
    private final InFocusRepo inFocusRepo;

    public InFocusService(InFocusRepo inFocusRepo) {
        this.inFocusRepo = inFocusRepo;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
