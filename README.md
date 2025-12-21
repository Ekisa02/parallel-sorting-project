# Parallel Sorting Algorithms Project

**Course:** COMP 412 – Parallel and Distributed Systems  
**Institution:** University of Eldoret  
**Academic Year:** 2025/2026  
**Submission Date:** 6 January 2026  
**Version:** 1.0.0  
**Last Updated:** December 2025  

---

## 📋 Table of Contents

- [Project Overview](#-project-overview)
- [Team Members](#-team-members)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation Guide](#-installation-guide)
- [Usage](#-usage)
- [Features](#-features)
- [Performance Metrics](#-performance-metrics)
- [Weekly Progress](#-weekly-progress)
- [Testing](#-testing)
- [Documentation](#-documentation)
- [Contributing](#-contributing)
- [License](#-license)
- [Acknowledgements](#-acknowledgements)
- [Project Status](#-project-status)

---

## 🚀 Project Overview

This project is an academic implementation and comparative study of **sequential, parallel, and simulated distributed sorting algorithms** using Java concurrency frameworks. The primary goal is to evaluate performance improvements gained through parallelism while addressing scalability, efficiency, and fault tolerance.

### Key Objectives

1. Implement classical sequential sorting algorithms  
2. Design and implement parallel sorting techniques using Java concurrency  
3. Simulate distributed processing using a master–worker model  
4. Measure and analyze performance metrics such as speedup and efficiency  
5. Provide comprehensive documentation and performance reports  

### Technologies Used

- **Programming Language:** Java 11+  
- **Concurrency Frameworks:** ForkJoinPool, ExecutorService, Java Threads  
- **Build Tool:** Apache Maven  
- **IDE:** Visual Studio Code  
- **Version Control:** Git & GitHub  
- **Documentation:** Markdown, Javadoc, Google Docs  

---

## 👥 Team Members

| Name | Registration Number | Role |
|-----|--------------------|------|
| **Ekisa Joseph** | BIT/050/22 | Team Lead & Integration Specialist |
| Selina Mwao | BIT/054/22 | Algorithm Developer |
| Ekai Dickson | BIT/066/21 | Performance Analyst |
| Churchill Bosire | BIT/032/22 | Documentation Specialist |
| Cornelius Rotich | BIT/022/22 | Testing Engineer |
| Lewis Gitari | BIT/013/22 | Code Quality Manager |
| Faith Musyoka | BIT/010/22 | UI & Visualization Developer |
| Linet Kipsat | BIT/046/22 | Dataset Manager |
| Stephen Kinyamaria | BIT/012/22 | Deployment Specialist |
| Clinton Ondaba | BIT/074/22 | Fault Tolerance Engineer |

---

## 🏗️ Project Structure

```text
parallel-sorting-project/
├── .vscode/                  # VS Code configuration
├── src/
│   ├── main/java/com/parallel/sorting/
│   │   ├── algorithms/       # Sorting implementations
│   │   │   ├── sequential/
│   │   │   ├── parallel/
│   │   │   └── distributed/
│   │   ├── metrics/          # Performance measurement
│   │   ├── utils/            # Utility classes
│   │   ├── visualization/    # Charts and graphs
│   │   └── Main.java         # Application entry point
│   └── test/java/            # Test cases
├── data/                     # Generated datasets
├── docs/                     # Design and reports
├── results/                  # Benchmark outputs
├── pom.xml                   # Maven configuration
├── README.md                 # Project documentation
└── .gitignore
