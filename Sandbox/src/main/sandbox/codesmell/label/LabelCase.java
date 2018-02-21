package sandbox.codesmell.label;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class LabelCase {
    private LabelCase() {

    }

    private static CargoMovementSpec getCargoMovementSpecByCustomsManifestLeg(BillOfLading billOfLading, CustomsManifestLeg customsManifestLeg) {
        if (billOfLading == null || customsManifestLeg == null) {
            return null;
        }
        CargoMovementSpec matchCargoMovementSpec = getMatchCargoMovementSpec(billOfLading.getPackages(), customsManifestLeg);
        return matchCargoMovementSpec != null ? matchCargoMovementSpec : getFirstCargoMovementSpec(billOfLading.getPackages());
    }

    private static CargoMovementSpec getFirstCargoMovementSpec(List<Package> packages) {
        Optional<Package> firstPackage = packages.stream()
                .filter(billOfLadingPackage -> billOfLadingPackage.getCargoMovementSpec() != null)
                .findFirst();
        return getCargoMovementSpec(firstPackage);
    }

    private static CargoMovementSpec getMatchCargoMovementSpec(List<Package> packages, CustomsManifestLeg customsManifestLeg) {
        Optional<Package> matchPackage = packages.stream()
                .filter(billOfLadingPackage -> billOfLadingPackage.getCargoMovementSpec() != null && isMatchLeg(billOfLadingPackage.getCargoMovementSpec(), customsManifestLeg))
                .findFirst();
        return getCargoMovementSpec(matchPackage);
    }

    private static CargoMovementSpec getCargoMovementSpec(Optional<Package> matchPackage) {
        if (!matchPackage.isPresent()) {
            return null;
        }
        return matchPackage.get().getCargoMovementSpec();
    }

    private static boolean isMatchLeg(CargoMovementSpec cargoMovementSpec, CustomsManifestLeg customsManifestLeg) {
        return cargoMovementSpec.getCmsLegs().stream()
                .anyMatch(cmsLeg -> cmsLeg.getLeg() != null && cmsLeg.getLeg().equals(customsManifestLeg.getLeg()));
    }

    private static boolean isMatchLegAnotherStyle(CargoMovementSpec cargoMovementSpec, CustomsManifestLeg customsManifestLeg) {
        Predicate<CmsLeg> cmsLegNotNull = cmsLeg -> cmsLeg.getLeg() != null;
        Predicate<CmsLeg> cmsLegMatchCustomsManifestLeg = cmsLeg -> cmsLeg.getLeg().equals(customsManifestLeg.getLeg());
        Predicate<CmsLeg> matchingCriteria = cmsLegNotNull.and(cmsLegMatchCustomsManifestLeg);
        return cargoMovementSpec.getCmsLegs().stream()
                .anyMatch(matchingCriteria);
    }
}
