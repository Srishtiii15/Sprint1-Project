package capgemini.emp_asset.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import capgemini.emp_asset.entity.Asset;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssetServiceImplTest {

	@Autowired
	private AssetServiceImpl assetService;
	
	@Test
	public void testGetAllAssets() {
		List<Asset> assets = assetService.getAllAssets();
		assertThat(assets.size()>0);
	}
	
	@Test
	public void testGetAsset() {
		Optional<Asset> asset = assetService.getAsset(1);
		assertThat(asset.get().getAssetId()==1);
	}
	
	@Test
	public void testAddAsset() {
		Asset ass = new Asset();
		ass.setAssetId(1);
		ass.setDescription("Laptop");
		ass.setType("Hardware");
		ass=assetService.addAsset(ass);
		assertThat(ass.getType().equalsIgnoreCase("Hardware"));
	}
	
	
	@Test
	public void testRemoveAsset() {
		Asset ass = new Asset();
		ass.setAssetId(4);
		ass.setDescription("Mouse");
		ass.setType("H/W");
		ass=assetService.addAsset(ass);
		assetService.removeAsset(ass);
		assertThat(ass.getAssetId()==0);
	}

	@Test
	public void testEditAsset() {
		Asset ass = new Asset();
		ass.setAssetId(2);
		ass.setDescription("Keyboard");
		ass.setType("HW");
		ass=assetService.editAsset(ass);
		assertThat(ass.getDescription().equalsIgnoreCase("Keyboard"));
	}

}
