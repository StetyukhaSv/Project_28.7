package org.example;

public enum StudyProfile {
    MEDICINE ("Медицина"),
    ECONOMY ("Экономика"),
    MANAGEMENT ("Менеджмент"),
    JURISPRUDENCE ("Юриспруденция"),
    APPLIED_COMPUTER_SCIENCE ("Прикладная информатика"),
    PSYCHOLOGY ("Психология"),
    ADVERTISING_AND_PUBLIC_RELATIONS ("Реклама и связи с общественностью"),
    TOURISM ("Туризм"),
    DESIGN ("Дизайн"),
    LINGUISTICS ("Лингвистика"),
    PHYSICS("Физика"),
    MATHEMATICS("Математика"),
    PERSONNEL_MANAGEMENT ("Управление персоналом");

    String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
