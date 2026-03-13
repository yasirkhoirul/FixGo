package com.example.core.component

data class ValidationResult(
    val errorMessage: String? = null,
)

object Validators {
    fun validatePhone(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                errorMessage = "Nomor HP tidak boleh kosong"
            )
        }
        val cleanInput = input.replace(" ", "").replace("-", "")
        val phoneRegex = "^\\+?[0-9]{9,15}$".toRegex()
        if (!cleanInput.matches(phoneRegex)) {
            return ValidationResult(
                errorMessage = "Format nomor HP tidak valid (9-15 digit angka)"
            )
        }
        if (!cleanInput.startsWith("08") &&
            !cleanInput.startsWith("62") &&
            !cleanInput.startsWith("+62")
        ) {
            return ValidationResult(
                errorMessage = "Nomor HP harus diawali 08 atau +62"
            )
        }
        return ValidationResult(
            errorMessage = null
        )
    }
}