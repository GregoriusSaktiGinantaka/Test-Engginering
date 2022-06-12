Feature: feature to test login functionality

  Scenario Outline: periksa login dengan akun yang benar
    Given browser dibuka
    And user berada di halaman login
    When user memasukan <username> dan <password>
    And tombol login ditekan
    Then user redirect ke halaman utama
    Examples:
      | username            | password       |
      |                     |                |
      | gregorius@gmail.com |                |
      |                     | 12345678       |
      | gregorius@gmail.com | 12345          |
      | gregorius@gmail.com | Sakti123456789 |
      | gregorius@gmail.com | 12345678       |