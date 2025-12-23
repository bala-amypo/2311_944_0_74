package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(ClaimRepository claimRepository,
                                     FraudRuleRepository fraudRuleRepository,
                                     FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<FraudRule> rules = fraudRuleRepository.findAll();
        boolean isFraud = false;
        String triggeredRule = null;
        String reason = null;

        for (FraudRule rule : rules) {
            if (rule.getConditionField().equals("claimAmount")) {
                double threshold = Double.parseDouble(rule.getValue());
                switch (rule.getOperator()) {
                    case ">": if (claim.getClaimAmount() > threshold) { isFraud = true; triggeredRule = rule.getRuleName(); reason = "Amount exceeds threshold"; } break;
                    case "<": if (claim.getClaimAmount() < threshold) { isFraud = true; triggeredRule = rule.getRuleName(); reason = "Amount below threshold"; } break;
                    // Add other operators as needed
                }
                if (isFraud) break;
            }
        }

        FraudCheckResult result = new FraudCheckResult(
                claim,
                isFraud,
                triggeredRule,
                reason,
                LocalDateTime.now()
        );
        return resultRepository.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
