Feature: feature to test register functionality

  Scenario Outline: daftarkan akun untuk login
    Given browser open
    And user berada di halaman register
    When users register dengan <email> dan <sandi>
    And tombol create ditekan
    Then user redirect ke halaman login
    Examples:
      |email                |sandi        |
      |                     |             |
      |gregorius@gmail.com  |             |
      |                     |12345678     |
      |gregorius@gmail.com  |12345678     |
