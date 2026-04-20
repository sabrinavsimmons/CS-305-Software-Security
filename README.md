# CS-305-Software-Security

This repository contains coursework from CS-305 Software Security at 
Southern New Hampshire University.

## Project

- **Project Two:** Practices for Secure Software Report — SHA-256 checksum 
verification and SSL/TLS implementation

## Developer
Sabrina Simmons

---

## Module 8 Journal Reflection

**Briefly summarize your client, Artemis Financial, and its software requirements.**

Artemis Financial is a consulting company that develops individualized financial 
plans covering savings, retirement, investments, and insurance. The company wanted 
to modernize its operations by adding a file verification step to its web application 
to ensure secure communications. Specifically, they needed a data verification 
mechanism in the form of a checksum, as well as secure HTTPS communication to 
protect sensitive client data in transit.

**What did you do well when you found your client's software security vulnerabilities? 
Why is it important to code securely? What value does software security add to a 
company's overall well-being?**

I did well at identifying and clearly documenting vulnerabilities across multiple 
categories including cryptography, input validation, API security, exception handling, 
encapsulation, and dependency management. I was thorough in connecting each finding 
to its real-world impact for a financial services company. Secure coding is important 
because vulnerabilities in software can lead to data breaches, regulatory penalties, 
and lasting reputational damage. For a company like Artemis Financial, which handles 
sensitive personal and financial data, software security is not optional — it is a 
core business requirement. Security built into the software from the start is far 
more effective than perimeter controls applied after the fact.

**Which part of the vulnerability assessment was challenging or helpful to you?**

The static testing phase using the OWASP Dependency-Check tool was both the most 
challenging and the most helpful part. It was challenging because the tool identified 
a large number of vulnerabilities across the transitive dependency tree, requiring 
careful analysis to distinguish between pre-existing vulnerabilities and anything 
introduced by my own refactoring. It was helpful because it gave me a systematic, 
repeatable way to assess the security posture of the entire codebase, not just the 
code I wrote directly.

**How did you increase layers of security? In the future, what would you use to 
assess vulnerabilities and decide which mitigation techniques to use?**

I increased layers of security by implementing SHA-256 cryptographic hash verification 
for data integrity and configuring SSL/TLS to convert the application from HTTP to 
HTTPS using a self-signed PKCS12 certificate generated with the Java Keytool. I also 
created a suppression file to document pre-existing vulnerabilities and confirmed that 
my refactored code introduced zero new vulnerabilities. In the future I would continue 
using the OWASP Dependency-Check tool for static analysis, combined with manual code 
review and the vulnerability assessment process flow diagram to systematically evaluate 
each security area and prioritize mitigations based on CVSSv3 severity scores.

**How did you make certain the code and software application were functional and secure? 
After refactoring the code, how did you check to see whether you introduced new 
vulnerabilities?**

I verified functionality by running the Spring Boot application and confirming the 
SHA-256 checksum endpoint returned the correct output at https://localhost:8443/hash, 
with the HTTPS padlock visible in the browser. I performed a manual functional review 
of the refactored code examining it for syntactical, logical, and security 
vulnerabilities. I then ran the OWASP Dependency-Check tool as a secondary static 
analysis to confirm that the SHA-256 implementation using Java's built-in
