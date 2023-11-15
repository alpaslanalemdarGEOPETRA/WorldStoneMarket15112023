#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel2  |
#| IT exam is1     | academicPeriod1              | gradeLevel3  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel4  |
#| Math exam is2   | academicPeriod1              | gradeLevel5  |

Feature: Exam functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Exam Create and Delete
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | ism941Exam1 |

    And Click on the element in Dialog
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

#    Silme ekranına ulaşmak için tekrar navigate yapıldı
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in Dialog
      | searchAcademicPeriod |
      | academicPeriod1      |

    And User delete the element from Dialog
      | ism941Exam1 |


    Then Success message should be displayed
