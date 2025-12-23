package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (fraudRuleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Rule name already exists");
        }

        if (!rule.getSeverity().matches("LOW|MEDIUM|HIGH")) {
            throw new IllegalArgumentException("Invalid severity");
        }

        return fraudRuleRepository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }
}
