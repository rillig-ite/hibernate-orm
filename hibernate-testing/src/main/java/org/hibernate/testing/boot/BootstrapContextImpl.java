/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.testing.boot;

import java.util.Collection;

import org.hibernate.boot.AttributeConverterInfo;
import org.hibernate.boot.archive.scan.spi.ScanEnvironment;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.hibernate.boot.archive.spi.ArchiveDescriptorFactory;
import org.hibernate.boot.internal.ClassmateContext;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.boot.spi.ClassLoaderAccess;
import org.hibernate.boot.spi.MetadataBuildingOptions;

/**
 * @author Andrea Boriero
 */
public class BootstrapContextImpl implements BootstrapContext {
	public static final BootstrapContextImpl INSTANCE = new BootstrapContextImpl();

	private BootstrapContext delegate;

	private BootstrapContextImpl() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
		MetadataBuildingOptions buildingOptions = new MetadataBuilderImpl.MetadataBuildingOptionsImpl( serviceRegistry );

		delegate = new org.hibernate.boot.internal.BootstrapContextImpl( serviceRegistry, null, buildingOptions );
	}

	@Override
	public StandardServiceRegistry getServiceRegistry() {
		return delegate.getServiceRegistry();
	}

	@Override
	public MetadataBuildingOptions getMetadataBuildingOptions() {
		return delegate.getMetadataBuildingOptions();
	}

	@Override
	public ClassLoader getJpaTempClassLoader() {
		return delegate.getJpaTempClassLoader();
	}

	@Override
	public ClassLoaderAccess getClassLoaderAccess() {
		return delegate.getClassLoaderAccess();
	}

	@Override
	public ClassmateContext getClassmateContext() {
		return delegate.getClassmateContext();
	}

	@Override
	public ArchiveDescriptorFactory getArchiveDescriptorFactory() {
		return delegate.getArchiveDescriptorFactory();
	}

	@Override
	public ScanOptions getScanOptions() {
		return delegate.getScanOptions();
	}

	@Override
	public ScanEnvironment getScanEnvironment() {
		return delegate.getScanEnvironment();
	}

	@Override
	public Object getScanner() {
		return delegate.getScanner();
	}

	@Override
	public Collection<AttributeConverterInfo> getAttributeConverters() {
		return delegate.getAttributeConverters();
	}

	@Override
	public void release() {
		delegate.release();
	}
}
