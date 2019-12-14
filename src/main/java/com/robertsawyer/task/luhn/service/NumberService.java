package com.robertsawyer.task.luhn.service;

import com.robertsawyer.task.luhn.dto.CheckNumberDTO;
import com.robertsawyer.task.luhn.entity.Number;
import com.robertsawyer.task.luhn.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NumberService {

    @Autowired
    private NumberRepository numberRepository;

    public static boolean checkIsCorrect(CheckNumberDTO numberDTO) {

        String number = numberDTO.getNumber();
        int sum = 0;
        boolean isEven = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(number.substring(i, i + 1));

            if (isEven) {
                digit *= 2;

                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            sum += digit;
            isEven = !isEven;
        }
        return (sum % 10 == 0);
    }

    @Transactional
    public void saveNumber(CheckNumberDTO numberDTO) {
        Number number = new Number();
        number.setCheckingNumber(numberDTO.getNumber());
        number.setIsCorrect(numberDTO.isCorrect());
        numberRepository.save(number);
    }
}
