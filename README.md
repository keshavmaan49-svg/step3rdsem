# STEP 3rd Semester — Project Folder Structure

This repository follows the standard STEP Java project hierarchy:

```text
step3rdsem/
└── src/
    ├── session_1_java_basics/
    │   ├── class_problem/
    │   │   ├── BmiCalculator.java
    │   │   ├── FirstNonRepeatingChar.java
    │   │   ├── PalindromeChecker.java
    │   │   ├── ReverseCustomerName.java
    │   │   └── RockPaperScissors.java
    │   └── assignment_problem/
    │       ├── MovieReviewProfiler.java
    │       ├── SeatDuplicationChecker.java
    │       ├── TrafficSignalStreak.java
    │       ├── TypingAccuracyChecker.java
    │       └── WarehouseInventory.java
    │
    ├── session_2_strings_and_methods/
    │   ├── class_problem/
    │   │   ├── BankReferenceValidator.java
    │   │   ├── FileExtensionValidator.java
    │   │   ├── PhoneNumberFormatter.java
    │   │   ├── StudentRecordParser.java
    │   │   └── VowelConsonantCounter.java
    │   └── assignment_problem/
    │       ├── InventoryRecordParser.java
    │       ├── IsbnValidator.java
    │       ├── PinValidator.java
    │       ├── WordFrequencyReport.java
    │       └── WordReversalEncoder.java
    │
    ├── session_3_oop_basics/
    │   ├── class_problem/
    │   │   ├── Course.java
    │   │   ├── IdCard.java
    │   │   ├── MessWallet.java
    │   │   ├── PlacementRecord.java
    │   │   ├── Student.java
    │   │   ├── DuplicateTeamFinder.java
    │   │   ├── HackathonScoreCurveBooster.java
    │   │   ├── PlacementShortlistEngine.java
    │   │   ├── SeatingGridOptimizer.java
    │   │   ├── TopThreePodiumFinder.java
    │   │   ├── TwoSum.java
    │   │   ├── BestTimeToBuyAndSellStock.java
    │   │   ├── ContainsDuplicate.java
    │   │   ├── MergeTwoSortedArrays.java
    │   │   └── RotateArray.java
    │   └── assignment_problem/
    │       ├── BookInventory.java
    │       ├── Employee.java
    │       ├── EmployeeStatic.java
    │       ├── HallTicket.java
    │       └── PayrollAccount.java
    │
    ├── session_4_constructors_and_keywords/
    │   ├── class_problem/
    │   │   ├── AccountPayment.java
    │   │   ├── Employee.java
    │   │   ├── LateFee.java
    │   │   ├── LibraryBook.java
    │   │   └── SrmStudent.java
    │   └── assignment_problem/
    │       ├── CanteenPayment.java
    │       ├── Item.java
    │       ├── MembershipCard.java
    │       ├── ParkingTicket.java
    │       └── Participant.java
    │
    ├── session_5_access_modifiers_and_encapsulation/
    │   ├── class_problem/
    │   │   ├── AccessChecker.java
    │   │   ├── BookingReceipt.java
    │   │   ├── CineScreen.java
    │   │   ├── MovieBookingProfile.java
    │   │   └── MovieTicket.java
    │   └── assignment_problem/
    │       ├── AccessChecker.java
    │       ├── BookInventory.java
    │       ├── LibraryMember.java
    │       ├── LoanReceipt.java
    │       └── ReferenceOnlyLoanReceipt.java
    │
    ├── session_6_inheritance_and_polymorphism/
    │   ├── class_problem/
    │   │   ├── CirculationReport.java
    │   │   ├── FacultyMember.java
    │   │   ├── HonorsStudentMember.java
    │   │   ├── LibraryMember.java
    │   │   └── StudentMember.java
    │   └── assignment_problem/
    │       ├── EliteMember.java
    │       ├── GroupClassMember.java
    │       ├── GymMember.java
    │       ├── GymReport.java
    │       └── PremiumMember.java
    │
    └── session_7_abstract_classes_and_interfaces/
        ├── class_problem/
        │   ├── DeliveryNote.java
        │   ├── Instrument.java
        │   ├── KitchenTool.java
        │   ├── Printable.java
        │   └── Toy.java
        └── assignment_problem/
            ├── DeliveryNote.java
            ├── Instrument.java
            ├── KitchenTool.java
            ├── Printable.java
            └── Toy.java
```

---

## 🌿 Branching Model

| Branch | Description |
|---|---|
| `main` | Production branch with complete project structure |
| `develop` | Integration branch for all session branches |
| `feature/session_1` | Session 1: Java Basics (`class_problem` & `assignment_problem`) |
| `feature/session_2` | Session 2: Strings & Methods (`class_problem` & `assignment_problem`) |
| `feature/session_3` | Session 3: OOP Basics (`class_problem` & `assignment_problem`) |
| `feature/session_4` | Session 4: Constructors & Keywords (`class_problem` & `assignment_problem`) |
| `feature/session_5` | Session 5: Access Modifiers & Encapsulation (`class_problem` & `assignment_problem`) |
| `feature/session_6` | Session 6: Inheritance & Polymorphism (`class_problem` & `assignment_problem`) |
| `feature/session_7` | Session 7: Abstract Classes & Interfaces (`class_problem` & `assignment_problem`) |

---

## 🚀 How to Run

```bash
# Compile and run any program:
javac src/session_1_java_basics/class_problem/RockPaperScissors.java
java -cp src/session_1_java_basics/class_problem RockPaperScissors

javac src/session_3_oop_basics/class_problem/PlacementShortlistEngine.java
java -cp src/session_3_oop_basics/class_problem PlacementShortlistEngine
```
