# STEP 3rd Semester — Project Folder Structure

This repository contains all Java classwork and assignment solutions for STEP 3rd Semester across Sessions 1 through 9, structured cleanly according to the STEP guidelines:

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
    ├── session_7_abstract_classes_and_interfaces/
    │   ├── class_problem/
    │   │   ├── DeliveryNote.java
    │   │   ├── Instrument.java
    │   │   ├── KitchenTool.java
    │   │   ├── Printable.java
    │   │   └── Toy.java
    │   └── assignment_problem/
    │       ├── DeliveryNote.java
    │       ├── Instrument.java
    │       ├── KitchenTool.java
    │       ├── Printable.java
    │       └── Toy.java
    │
    ├── session_8_inheritance_and_polymorphism/
    │   ├── class_problem/
    │   │   ├── PaymentSystemFeeCalculator.java       # Payment Processing & Fee Calculation (Card, Wallet, Bank Transfer)
    │   │   ├── LibraryItemDueDateCalculator.java      # Item Borrowing Duration & Due Dates (Book, DVD, Magazine)
    │   │   ├── DeliveryFeeCalculator.java             # Weight, Distance & International Customs Calculation
    │   │   ├── ExamQuestionGrader.java                # MCQ, True/False & Essay Keyword Scoring
    │   │   └── PublicTransportFareCalculator.java     # Bus, Train & Metro Peak Hour Fares
    │   └── assignment_problem/
    │       ├── CanteenBillingCounter.java             # Student (-10%), Staff (-5%) & Guest (+₹10) Counter
    │       ├── CampusParkingChargeCalculator.java     # Bike (₹10/h), Car (₹30+₹20/h), Truck (₹50/h, min ₹100)
    │       ├── HostelElectricityBill.java             # Single (₹8/u), Shared (₹6/u ÷ n), AC (₹10/u + ₹200)
    │       ├── FestivalBonusCalculator.java           # Full-Time (10%), Part-Time (5%), Intern (Fixed ₹2,000)
    │       └── StreamingPlanRenewalReminder.java      # Basic (30d), Standard (90d), Premium (365d) Subscriptions
    │
    └── session_9_abstract_classes_and_interfaces/
        ├── class_problem/
        │   ├── GardenPlotAreaReport.java              # Circle (πr²), Rectangle (l×w), Triangle (½bh) Plots
        │   ├── WeeklyStaffPay.java                    # Fixed Salary, Hourly (Overtime 1.5×) & Stipends
        │   ├── LibraryLateFineCounter.java            # Daily Rate & Max Fine Caps
        │   ├── ElectricityConnectionBilling.java      # Home Slabs, Shop Fixed & Factory Minimums
        │   └── TravelBookingFeeCalculator.java        # Bus, Train & Flight with Shared Booking Fee (₹50)
        └── assignment_problem/
            ├── MovieTicketCounter.java                # Regular, Premium & Recliner with Convenience Fee (₹20)
            ├── ParcelShippingDesk.java                # Standard, Express & Fragile Parcel Insurance
            ├── CollegeFeeCounter.java                 # Day Scholar, Hosteller & Scholar with BusUser Interface
            ├── CityCabFareMeter.java                  # Mini, Sedan & SUV with Night Service & Minimum Fare
            └── HomeApplianceEnergyReport.java         # Power Ratings & Saver Mode 25% Energy Reduction
```

---

## 🌿 Branching Model

| Branch | Description |
|---|---|
| `main` | Production branch with complete project structure across all 9 sessions |
| `develop` | Integration branch for all session branches |
| `feature/session_1` | Session 1: Java Basics (`class_problem` & `assignment_problem`) |
| `feature/session_2` | Session 2: Strings & Methods (`class_problem` & `assignment_problem`) |
| `feature/session_3` | Session 3: OOP Basics (`class_problem` & `assignment_problem`) |
| `feature/session_4` | Session 4: Constructors & Keywords (`class_problem` & `assignment_problem`) |
| `feature/session_5` | Session 5: Access Modifiers & Encapsulation (`class_problem` & `assignment_problem`) |
| `feature/session_6` | Session 6: Inheritance & Polymorphism (Gym & Library Member Hierarchies) |
| `feature/session_7` | Session 7: Abstract Classes & Interfaces (Instruments, Tools & Toys) |
| `feature/session_8` | Session 8: Inheritance & Dynamic Dispatch (Billing, Parking, Delivery & Transport) |
| `feature/session_9` | Session 9: Abstract Classes & Interfaces (Plots, Payroll, Fares & Appliances) |

---

## 🚀 How to Run

```bash
# Run Session 8 Classwork: Payment System Fee Calculator
javac src/session_8_inheritance_and_polymorphism/class_problem/PaymentSystemFeeCalculator.java
java -cp src/session_8_inheritance_and_polymorphism/class_problem PaymentSystemFeeCalculator

# Run Session 8 Assignment: Canteen Billing Counter
javac src/session_8_inheritance_and_polymorphism/assignment_problem/CanteenBillingCounter.java
java -cp src/session_8_inheritance_and_polymorphism/assignment_problem CanteenBillingCounter

# Run Session 9 Classwork: Garden Plot Area Report
javac src/session_9_abstract_classes_and_interfaces/class_problem/GardenPlotAreaReport.java
java -cp src/session_9_abstract_classes_and_interfaces/class_problem GardenPlotAreaReport

# Run Session 9 Assignment: Movie Ticket Counter
javac src/session_9_abstract_classes_and_interfaces/assignment_problem/MovieTicketCounter.java
java -cp src/session_9_abstract_classes_and_interfaces/assignment_problem MovieTicketCounter
```
