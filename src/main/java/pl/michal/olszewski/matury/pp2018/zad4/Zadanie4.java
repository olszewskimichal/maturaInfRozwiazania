package pl.michal.olszewski.matury.pp2018.zad4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Zadanie4 {

	public static void main(String[] args) throws IOException {
		List<Harcerz> readAllHarcerzFromFiles = readAllHarcerzFromFiles();
		List<Sprawnosc> sprawnosci = readAllSprawnoscFromFiles();
		List<Dzialania> dzialaniaFromFiles = readAllDzialaniaFromFiles();
		updateDzialania(dzialaniaFromFiles, readAllHarcerzFromFiles, sprawnosci);

		System.out.println("zad 4.1");
		readAllHarcerzFromFiles
				.stream()
				.collect(Collectors.groupingBy(Harcerz::getTeam, Collectors.counting()))
				.forEach((v1, v2) -> System.out.println(v1 + " " + v2));

		System.out.println("zad 4.2");
		findFirstValueWithOrder(sprawnosci,(v2, v1) -> Integer.compare(v1.getPointsSum(), v2.getPointsSum()))
				.ifPresent(v -> System.out.println(v.getName() + " " + v.getPointsSum()));
		findFirstValueWithOrder(sprawnosci, Comparator.comparingInt(Sprawnosc::getPointsSum))
				.ifPresent(v -> System.out.println(v.getName() + " " + v.getPointsSum()));

		System.out.println("zad 4.3");
		readAllHarcerzFromFiles
				.stream()
				.sorted(Comparator.comparingLong(Harcerz::ileSprawnosci))
				.forEach(v -> System.out.println(v.getName() + " " + v.getLastName() + " " + v.ileSprawnosci()));

		System.out.println("zad 4.4");
		Map<String, List<Harcerz>> collect = readAllHarcerzFromFiles
				.stream()
				.collect(Collectors.groupingBy(Harcerz::getTeam));
		for (Entry<String, List<Harcerz>> entry : collect.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue().stream().mapToInt(v -> v.ileSprawnosci().intValue()).sum());
		}

		System.out.println("zad 4.5");
		readAllHarcerzFromFiles
				.stream()
				.max(Comparator.comparingLong(v2 -> v2.getMaxSprawnoscDays().days()))
				.ifPresent(v -> System.out.println(v.getName() + " " + v.getLastName() + " " + v.getMaxSprawnoscDays().getSprawnosc().getName() + " " + v.getMaxSprawnoscDays().days()));
	}

	private static Optional<Sprawnosc> findFirstValueWithOrder(List<Sprawnosc> sprawnosci, Comparator<? super Sprawnosc> comparator) {
		return sprawnosci.stream().min(comparator);
	}

	private static List<Dzialania> readAllDzialaniaFromFiles() throws IOException {
		return Files.readAllLines(Paths.get("dzialania.txt"), StandardCharsets.ISO_8859_1)
				.stream()
				.skip(1)
				.map(SplitLineToDzialaniaPOJO::split)
				.collect(Collectors.toList());
	}

	private static List<Harcerz> readAllHarcerzFromFiles() throws IOException {
		return Files.readAllLines(Paths.get("harcerze.txt"), StandardCharsets.ISO_8859_1)
				.stream()
				.skip(1)
				.map(SplitLineToHarcerz::split)
				.collect(Collectors.toList());
	}

	private static List<Sprawnosc> readAllSprawnoscFromFiles() throws IOException {
		return Files.readAllLines(Paths.get("sprawnosc.txt"), StandardCharsets.ISO_8859_1)
				.stream()
				.skip(1)
				.map(SplitLineToSprawnosc::split)
				.collect(Collectors.toList());
	}

	private static void updateDzialania(List<Dzialania> dzialania, List<Harcerz> harcerze, List<Sprawnosc> sprawnosci) {
		for (Dzialania dzialanie : dzialania) {
			Harcerz harcerzById = findHarcerzById(dzialanie.getHarcerzId(), harcerze);
			Sprawnosc sprawnoscById = findSprawnoscById(dzialanie.getSprawnoscId(), sprawnosci);
			dzialanie.setSprawnosc(sprawnoscById);
			sprawnoscById.getDzialania().add(dzialanie);
			harcerzById.getDzialania().add(dzialanie);
		}
	}

	private static Harcerz findHarcerzById(String id, List<Harcerz> harcerze) {
		return harcerze.stream().filter(v -> v.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Nie znaleziono harcerza o id " + id));
	}

	private static Sprawnosc findSprawnoscById(String id, List<Sprawnosc> sprawnosci) {
		return sprawnosci.stream().filter(v -> v.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Nie znaleziono sprawnosci o id " + id));
	}

}
