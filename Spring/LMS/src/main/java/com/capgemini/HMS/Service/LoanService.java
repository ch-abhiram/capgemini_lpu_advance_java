package com.capgemini.HMS.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.HMS.Entity.Book;
import com.capgemini.HMS.Entity.Loan;
import com.capgemini.HMS.Entity.Member;
import com.capgemini.HMS.Repository.BookRepository;
import com.capgemini.HMS.Repository.LoanRepository;
import com.capgemini.HMS.Repository.MemberRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanjpa;

    @Autowired
    private BookRepository bookjpa;

    @Autowired
    private MemberRepository memberjpa;

    public Loan issueBook(Long memberId, Long bookId, LocalDate dueDate) {

        Member member = memberjpa.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Book book = bookjpa.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getCopiesAvailable() <= 0)
            throw new RuntimeException("No copies available");

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);

        Loan loan = new Loan();
        loan.setIssueDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setLoanStatus("ISSUED");
        loan.setMember(member);
        loan.setBook(book);

        bookjpa.save(book);
        return loanjpa.save(loan);
    }

    public Loan returnBook(Long loanId) {

        Loan loan = loanjpa.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getLoanStatus().equals("RETURNED"))
            throw new RuntimeException("Book already returned");

        loan.setReturnDate(LocalDate.now());
        loan.setLoanStatus("RETURNED");

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);

        bookjpa.save(book);
        return loanjpa.save(loan);
    }

    public Loan getLoanById(Long id) {
        return loanjpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public List<Loan> getAllLoans() {
        return loanjpa.findAll();
    }

    public List<Loan> getLoansByMember(Long memberId) {
        return loanjpa.findByMemberMemberId(memberId);
    }
}
